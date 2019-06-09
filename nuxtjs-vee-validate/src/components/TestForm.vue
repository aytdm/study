<template>
  <div>
    <form>
      <div>
        <label for="name">Name:</label>
        <input
          id="name"
          v-model.trim="name"
          v-validate="'required'"
          :class="{'error': errors.has('name')}"
          data-vv-validate-on="blur"
          name="name"
          type="text"
        >
        <div
          v-show="errors.has('name')"
          id="name-error"
          class="has-error"
        >{{ errors.first('name') }}</div>
      </div>
      <div>
        <label for="message">Message:</label>
        <textarea
          id="message"
          v-model="message"
          v-validate="'required'"
          :class="{'error': errors.has('message')}"
          data-vv-validate-on="blur"
          name="message"
        />
        <div
          v-show="errors.has('message')"
          id="message-error"
          class="has-error"
        >{{ errors.first('message') }}</div>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  inject: ["$validator"],
  data() {
    return {
      name: "",
      message: ""
    };
  }
};
</script>

<style scoped>
input,
textarea {
  width: 100%;
  display: block;
  border: 1px solid #eee;
  box-sizing: border-box;
  padding: 15px 20px;
  margin: 16px 0;
}

textarea {
  height: 100px;
}

.error {
  border-color: #f85d5d;
}

.has-error {
  color: #f85d5d;
  margin-bottom: 15px;
}
</style>