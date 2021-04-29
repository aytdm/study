package com.aytdm.kotlinbootdoma.app.form

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class CustomerForm {
    @NotBlank
    @Size(max = 20)
    var name: String? = null

    @NotBlank
    @Size(max = 50)
    var email: String? = null
}