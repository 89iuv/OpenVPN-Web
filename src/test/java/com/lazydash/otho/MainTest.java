package com.lazydash.otho;

import com.lazydash.otho.model.Client;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by valiuv on 5/8/2017.
 */
public class MainTest {

    /**
     * Read openvpn-status.log and create java clients from it.
     */
    @Test
    public void testCreateClients() throws Exception {
        Path openvpnStatusPath = Paths.get("src/test/resources/openvpn-status.log");
        List<String> strings = Files.readAllLines(openvpnStatusPath);

        boolean run = false;
        LinkedList<Client> clients = new LinkedList<>();
        for (String line: strings){

            if ("Virtual Address,Common Name,Real Address,Last Ref".equals(line)){
                run = true;
                continue;
            }

            if ("GLOBAL STATS".equals(line)){
                break;
            }

            if (run) {
                System.out.println(line);
                String[] words = line.split(",");
                Client client = new Client();
                client.setVirtualAddress(words[0]);
                client.setCommonName(words[1]);
                client.setRealAddress(words[2]);
                clients.add(client);
            }

        }

        for (Client client: clients){
            System.out.println(client);

        }
    }

}
