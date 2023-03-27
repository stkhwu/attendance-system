<template>
  <div id="app">
    <Dance-Participant />
    <Dance-Practice />
    <Dance-Attendance />
  </div>
</template>

<script>
import DanceParticipant from "@/components/DanceParticipant.vue";
import DancePractice from "@/components/DancePractice.vue";
import DanceAttendance from "@/components/DanceAttendance.vue";

export default {
  components: {
    DanceParticipant,
    DancePractice,
    DanceAttendance,
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>