package com.github.johnlayton.amberleyway.sal.client

import com.github.johnlayton.amberleyway.AmberleyWay
import com.github.johnlayton.amberleyway.sal.model.AmberleyWayRequest
import com.github.johnlayton.amberleyway.sal.model.AmberleyWayResponse
import reactor.core.publisher.Mono

//@Component
//class DemoWebClient(address: String) : DemoClient {
class AmberleyWayClientImpl(private val amberleyway : AmberleyWay) : AmberleyWayClient {

//    val client = WebClient.builder().baseUrl(address).build();

    override fun sayHello(request: AmberleyWayRequest): Mono<AmberleyWayResponse> {
        return Mono.just(amberleyway.sayHello(request.let {
            com.github.johnlayton.amberleyway.AmberleyWayRequest().apply {
                id = it.id
                name = it.name
            }
        }).let {
            AmberleyWayResponse(it.id, it.name)
        })
//        return client.post()
//                .bodyValue(request)
//                .retrieve()
//                .bodyToMono(DemoResponse::class.java)
    }

}