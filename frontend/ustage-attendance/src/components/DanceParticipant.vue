<template>
  <div>
    <h1>Participants</h1>
    <div>
      <input v-model="newParticipant" placeholder="Add participant" />
      <button @click="addParticipant">Add</button>
    </div>
    <ul>
      <li v-for="participant in participants" :key="participant.id">
        <input v-model="participant.name" />
        <button @click="updateParticipant(participant)">Update</button>
        <button @click="deleteParticipant(participant.id)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'DanceParticipant',
  data() {
    return {
      participants: [],
      newParticipant: "",
      host: "http://localhost:8081",
    };
  },
  async created() {
    await this.fetchParticipants();
  },
  methods: {
    async fetchParticipants() {
      try {
        const response = await axios.get(`${this.host}/api/v1/participants`);
        this.participants = response.data;
      } catch (error) {
        console.error(error);
      }
    },
    async addParticipant() {
      try {
        if (this.newParticipant) {
          await axios.post(`${this.host}/api/v1/participants`, [
            this.newParticipant,
          ]);
          this.newParticipant = "";
          await this.fetchParticipants();
        }
      } catch (error) {
        console.error(error);
      }
    },
    async deleteParticipant(id) {
      try {
        await axios.delete(`${this.host}/api/v1/participants`, {
          data: [id],
        });
        await this.fetchParticipants();
      } catch (error) {
        console.error(error);
      }
    },
    async updateParticipant(participant) {
      try {
        await axios.put(`${this.host}/api/v1/participants`, [
          {
            id: participant.id,
            name: participant.name,
          },
        ]);
        await this.fetchParticipants();
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
