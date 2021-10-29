package com.example.soapproject.controller;


import com.example.soapproject.model.GetCarRequest;
import com.example.soapproject.model.GetCarResponse;
import com.example.soapproject.service.CarService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PayloadRoot(namespace = "http://bootcamp.com/", localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCarRequest(@RequestPayload GetCarRequest request) {
        GetCarResponse response = new GetCarResponse();
        response.setCar(carService.getCars(request.getModel()));
        return response;
    }
}