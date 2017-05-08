package com.lazydash.vpn.web.rest;

import com.lazydash.vpn.web.service.LinuxService;
import com.lazydash.vpn.web.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by valiuv on 5/8/2017.
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    private LinuxService linuxService;

    @Autowired
    public void setLinuxService(LinuxService linuxService) {
        this.linuxService = linuxService;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> getClient(){
        return linuxService.getConnectedClients();
    }

}
