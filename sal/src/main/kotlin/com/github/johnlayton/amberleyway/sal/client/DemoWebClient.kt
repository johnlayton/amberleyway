package com.github.johnlayton.amberleyway.sal.client

import com.github.johnlayton.soap.service.api.model.DemoService
import com.github.johnlayton.amberleyway.sal.model.AmberleyWayRequest
import com.github.johnlayton.amberleyway.sal.model.AmberleyWayResponse
import reactor.core.publisher.Mono

//@Component
//class DemoWebClient(address: String) : DemoClient {
class DemoWebClient(private val demoService : DemoService) : AmberleyWayClient {

//    val client = WebClient.builder().baseUrl(address).build();

    override fun sayHello(request: AmberleyWayRequest): Mono<AmberleyWayResponse> {
        return Mono.just(demoService.sayHello(request.let {
            com.github.johnlayton.soap.service.api.model.DemoRequest().apply {
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