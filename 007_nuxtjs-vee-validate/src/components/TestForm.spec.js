/* eslint-env jest */

import { createLocalVue, shallowMount } from "@vue/test-utils";
import flushPromises from "flush-promises";
import ValidationProvider, { Validator } from "vee-validate";
import TestForm from "@/components/TestForm.vue";
import dictionary from "@/plugins/validateDictionary";

describe("ContactForm.Vue", () => {
  let wrapper;
  const localVue = createLocalVue();

  beforeAll(() => {
    localVue.use(ValidationProvider, { inject: false });
    Validator.localize("en", dictionary);
    wrapper = shallowMount(TestForm, {
      sync: false,
      localVue
    });
  });

  /*
  beforeEach(() => {
    wrapper = shallowMount(TestForm, {
      sync: false,
      localVue
    });
  });
  */

  afterEach(() => {
    wrapper.destroy();
  });

  /*
  test("If the name is empty, an error message is displayed.", async () => {
    const error = wrapper.find("#name-error");
    expect(error.text()).toBe("");

    wrapper.find("#name").trigger("blur");
    await flushPromises();

    expect(error.text()).toBe("Please enter your name");
  });

  test("If the name is not empty, an error message is not displayed.", async () => {
    const error = wrapper.find("#name-error");
    expect(error.text()).toBe("");

    wrapper.find("#name").setValue("test");
    wrapper.find("#name").trigger("blur");
    await flushPromises();

    expect(error.text()).toBe("");
  });
  */

  /*
  test("If the message is empty, an error message is displayed.", async () => {
    const error = wrapper.find("#message-error");
    expect(error.text()).toBe("");

    wrapper.find("#message").trigger("blur");
    await flushPromises();

    expect(error.text()).toBe("Please enter your message");
  });
  */

  /* TODO: Fix me */
  test("If the message is not empty, an error message is not displayed.", async () => {
    const error = wrapper.find("#message-error");
    expect(error.text()).toBe("");

    const message = wrapper.find("#message");
    message.setValue("Hello from test");
    message.trigger("blur");
    await flushPromises();

    expect(message.element.value).toEqual("Hello from test");
    expect(error.text()).toBe("");
  });
});
