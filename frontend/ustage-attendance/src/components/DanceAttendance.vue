<template>
  <div>
    <h1>Attendance</h1>
    <div>
      <select v-model="newAttendance.participantId">
        <option disabled value="">Select Participant</option>
        <option v-for="participant in participants" :key="participant.id" :value="participant.id">
          {{ participant.name }}
        </option>
      </select>
      <select v-model="newAttendance.practiceId">
        <option disabled value="">Select Practice</option>
        <option v-for="practice in practices" :key="practice.id" :value="practice.id">
          {{ practice.date }} - {{ practice.venue }}
        </option>
      </select>
      <button @click="addAttendance">Add</button>
    </div>
    <ul>
      <li v-for="attendance in attendances" :key="attendance.id">
        {{ getParticipantName(attendance.participantId) }} - {{ getPracticeDetails(attendance.practiceId) }}
        <button @click="deleteAttendance(attendance.id)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'DanceAttendance',
  data() {
    return {
      attendances: [],
      participants: [],
      practices: [],
      newAttendance: {
        participantId: "",
        practiceId: "",
      },
      host: "http://localhost:8081",
    };
  },
  async created() {
    await this.fetchAttendances();
    await this.fetchParticipants();
    await this.fetchPractices();
  },
  methods: {
    async fetchAttendances() {
      try {
        const response = await axios.get(`${this.host}/api/v1/attendances`);
        this.attendances = response.data;
      } catch (error) {
        console.error(error);
      }
    },
    async fetchParticipants() {
      try {
        const response = await axios.get(`${this.host}/api/v1/participants`);
        this.participants = response.data;
      } catch (error) {
        console.error(error);
      }
    },
    async fetchPractices() {
      try {
        const response = await axios.get(`${this.host}/api/v1/practices`);
        this.practices = response.data;
      } catch (error) {
        console.error(error);
      }
    },
    async addAttendance() {
      try {
        if (this.newAttendance.participantId && this.newAttendance.practiceId) {
          await axios.post(`${this.host}/api/v1/attendances`, [this.newAttendance]);
          this.newAttendance = {
            participantId: "",
            practiceId: "",
          };
          await this.fetchAttendances();
        }
      } catch (error) {
        console.error(error);
      }
    },
    async deleteAttendance(id) {
      try {
        await axios.delete(`${this.host}/api/v1/attendances`, {
          data: [id],
        });
        await this.fetchAttendances();
      } catch (error) {
        console.error(error);
      }
    },
    getParticipantName(participantId) {
      const participant = this.participants.find(p => p.id === participantId);
      return participant ? participant.name : "";
    },
    getPracticeDetails(practiceId) {
      const practice = this.practices.find(p => p.id === practiceId);
      return practice ? `${practice.date} - ${practice.venue}` : "";
    },
  },
};
</script>

<style scoped>
ul {
  list-style-type: none;
  padding:0;
}

li {
display: flex;
align-items: center;
margin-bottom: 5px;
}

select {
margin-right: 10px;
}
</style>
