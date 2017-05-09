package com.lazydash.otho.service;

import com.lazydash.otho.config.AppConfig;
import com.lazydash.otho.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by valiuv on 5/8/2017.
 */
@Component
public class LinuxService {
    private AppConfig appConfig;

    @Autowired
    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public List<Client> getConnectedClients() {
        Path openvpnStatusPath = Paths.get(appConfig.getOpenvpnStatusFile());
        List<String> strings = null;
        try {
            strings = Files.readAllLines(openvpnStatusPath);

        } catch (IOException e) {
            e.printStackTrace();
            strings = new ArrayList<>();
        }

        boolean run = false;
        LinkedList<Client> clients = new LinkedList<>();
        for (String line : strings) {

            if ("Virtual Address,Common Name,Real Address,Last Ref".equals(line)) {
                run = true;
                continue;
            }

            if ("GLOBAL STATS".equals(line)) {
                break;
            }

            if (run) {
                String[] words = line.split(",");
                Client client = new Client();
                client.setVirtualAddress(words[0]);
                client.setCommonName(words[1]);
                client.setRealAddress(words[2]);
                clients.add(client);
            }

        }

        return clients;
    }
}
