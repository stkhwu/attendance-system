<template>
  <div>
    <h1>Practices</h1>
    <div>
      <input v-model="newPractice.date" type="date" placeholder="Date" />
      <input v-model="newPractice.venue" placeholder="Venue" />
      <input v-model="newPractice.startTime" type="time" placeholder="Start Time" />
      <input v-model="newPractice.endTime" type="time" placeholder="End Time" />
      <button @click="addPractice">Add</button>
    </div>
    <ul>
      <li v-for="practice in practices" :key="practice.id">
        <input v-model="practice.date" type="date" />
        <input v-model="practice.venue" />
        <input v-model="practice.startTime" type="time" />
        <input v-model="practice.endTime" type="time" />
        <button @click="updatePractice(practice)">Update</button>
        <button @click="deletePractice(practice.id)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'DancePractice',
  data() {
    return {
      practices: [],
      newPractice: {
        date: "",
        venue: "",
        startTime: "",
        endTime: "",
      },
      host: "http://localhost:8081",
    };
  },
  async created() {
    await this.fetchPractices();
  },
  methods: {
    async fetchPractices() {
      try {
        const response = await axios.get(`${this.host}/api/v1/practices`);
        this.practices = response.data;
      } catch (error) {
        console.error(error);
      }
    },
    async addPractice() {
      try {
        if (
          this.newPractice.date &&
          this.newPractice.venue &&
          this.newPractice.startTime &&
          this.newPractice.endTime
        ) {
          await axios.post(`${this.host}/api/v1/practices`, [this.newPractice]);
          this.newPractice = {
            date: "",
            venue: "",
            startTime: "",
            endTime: "",
          };
          await this.fetchPractices();
        }
      } catch (error) {
        console.error(error);
      }
    },
    async deletePractice(id) {
      try {
        await axios.delete(`${this.host}/api/v1/practices`, {
          data: [id],
        });
        await this.fetchPractices();
      } catch (error) {
        console.error(error);
      }
    },
    async updatePractice(practice) {
      try {
        await axios.put(`${this.host}/api/v1/practices`, [
          {
            id: practice.id,
            date: practice.date,
            venue: practice.venue,
            startTime: practice.startTime,
            endTime: practice.endTime,
          },
        ]);
        await this.fetchPractices();
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

input {
  margin-right: 10px;
}
</style>
