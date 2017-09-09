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
import java.util.Optional;

/**
 * Created by valiuv on 5/8/2017.
 */
@Component
public class LinuxService {
    private AppConfig appConfig;

    private String clientListRegex = ".+,\\d+.\\d+.\\d+.\\d+:\\d+,\\d+,\\d+,.+";
    private String routingTableRegex = "\\d+.\\d+.\\d+.\\d+,.+,\\d+.\\d+.\\d+.\\d+:\\d+,.+";

    @Autowired
    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public List<Client> getConnectedClients() {
        Path openvpnStatusPath = Paths.get(appConfig.getOpenvpnStatusFile());
        List<String> lines = getLinesFromPath(openvpnStatusPath);

        List<Client> clients = new LinkedList<>();
        for (String line : lines) {
            if (line.matches(clientListRegex)){
                String[] words = line.split(",");
                String name = words[0];

                Client client = getClientFromClientsByName(clients, name);

                client.setRealAddress(words[1]);
                client.setBytesReceived(words[2]);
                client.setBytesSent(words[3]);
                client.setConnectedSince(words[4]);

            } else if (line.matches(routingTableRegex)){
                String[] words = line.split(",");
                String name = words[1];

                Client client = getClientFromClientsByName(clients, name);

                client.setVirtualAddress(words[0]);
                client.setLastRef(words[3]);

            };
        }

        return clients;
    }

    private Client getClientFromClientsByName(List<Client> clients, String name){
        Optional<Client> first = clients.stream()
                .filter(client -> (name.equals(client.getCommonName())))
                .findFirst();

        Client client = null;
        if (first.isPresent()){
            client = first.get();

        } else {
            client = new Client(name);
            clients.add(client);
        }

        return client;
    }

    private List<String> getLinesFromPath(Path path){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);

        } catch (IOException e) {
            e.printStackTrace();
            lines = new ArrayList<>();
        }

        return lines;
    }
}
