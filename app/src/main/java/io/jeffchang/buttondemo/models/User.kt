package io.jeffchang.buttondemo.models

/**
 * POJO for response from the users API endpoint.
 */

data class User(var id: Int,
                var name: String,
                var email: String,
                var candidate: String)