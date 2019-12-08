package com.aytdm.kotlinbootdoma.app.controller

import com.aytdm.kotlinbootdoma.app.form.CustomerForm
import com.aytdm.kotlinbootdoma.domain.service.CustomerService
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.io.IOException


@Controller
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("")
    fun index(model: Model): String {

        val customers = customerService.findAll()
        model.addAttribute("customers", customers)
        return "customers/index"
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Int,
             model: Model): String {

        val customer = customerService.findById(id)
        model.addAttribute("customer", customer)
        return "customers/show"
    }

    @GetMapping("new")
    fun new(form: CustomerForm): String {

        return "customers/new"
    }

    @PostMapping("")
    fun create(@Validated customerForm: CustomerForm,
               bindingResult: BindingResult): String {

        if(bindingResult.hasErrors()) {
            return "customers/new"
        }

        val id = customerService.create(customerForm)

        return "redirect:/customers"
    }

    @GetMapping("{id}/edit")
    fun edit(@PathVariable id: Int,
             customerForm: CustomerForm): String {

        val customer = customerService.findById(id)

        customerForm.name = customer.name
        customerForm.email = customer.email

        return "customers/edit"
    }

    @PatchMapping("{id}")
    fun update(@PathVariable id: Int,
               @Validated customerForm: CustomerForm, bindingResult: BindingResult): String {

        if(bindingResult.hasErrors()) {
            return "customers/edit"
        }

        customerService.update(id, customerForm)
        return "redirect:/customers"
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Int): String {

        customerService.delete(id)
        return "redirect:/customers"
    }
}