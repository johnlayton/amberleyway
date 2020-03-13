package com.github.johnlayton.amberleyway.sal.client

import com.github.johnlayton.amberleyway.api.model.AmberleyWay
import com.github.johnlayton.amberleyway.api.model.AmberleyWayRequest as AmberleyWayApiRequest
import com.github.johnlayton.amberleyway.sal.model.AmberleyWayRequest as AmberleyWaySalRequest
import com.github.johnlayton.amberleyway.sal.model.AmberleyWayResponse as AmberleyWaySalResponse
import reactor.core.publisher.Mono

//@Component
//class DemoWebClient(address: String) : DemoClient {
class AmberleyWayClientImpl(private val amberleyway : AmberleyWay) : AmberleyWayClient {

//    val client = WebClient.builder().baseUrl(address).build();

    override fun sayHello(request: AmberleyWaySalRequest): Mono<AmberleyWaySalResponse> {
        return Mono.just(amberleyway.sayHello(request.let {
            AmberleyWayApiRequest().apply {
                id = it.id
                name = it.name
            }
        }).let {
            AmberleyWaySalResponse(it.id, it.name)
        })
//        return client.post()
//                .bodyValue(request)
//                .retrieve()
//                .bodyToMono(DemoResponse::class.java)
    }

}