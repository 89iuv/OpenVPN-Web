package com.lazydash.otho.service;


import com.lazydash.otho.config.AppConfig;
import com.lazydash.otho.model.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LinuxServiceTest {

    @Mock
    private AppConfig appConfig;

    @InjectMocks
    private LinuxService linuxService;

    @Test
    public void testUpdateClientFromStatusLog() throws URISyntaxException {
        //given
        Path path = Paths.get("src/test/resources/openvpn-status.log");
        when(appConfig.getOpenvpnStatusFile()).thenReturn(path.toString());

        //when
        ArrayList<Client> clients = new ArrayList<>();
        linuxService.updateClientsWithStatusInfo(clients);

        //then
        clients.forEach(System.out::println);

    }

    @Test
    public void testUpdateClientsFromIndex() throws URISyntaxException {
        //given
        List<Client> expectedClients = new ArrayList<>();
        expectedClients.add(new Client("server"));
        expectedClients.add(new Client("hades"));
        expectedClients.add(new Client("aphrodite"));
        expectedClients.add(new Client("zeus"));
        expectedClients.add(new Client("ares"));
        expectedClients.add(new Client("apollo"));

        when(appConfig.getOpenvpnIndexFile()).thenReturn("src/test/resources/index.txt");

        //when
        List<Client> actualClients = new ArrayList<>();
        linuxService.updateClientsWithCertificateInfo(actualClients);

        //then
        actualClients.forEach(System.out::println);

        Assert.assertEquals(expectedClients.size(), actualClients.size());
        for (int i = 0; i<expectedClients.size(); i++){
            Assert.assertEquals(expectedClients.get(i), actualClients.get(i));
        }

    }

    @Test
    public void testPartialUpdateClientsFromIndex() throws URISyntaxException {
        //given
        List<Client> expectedClients = new ArrayList<>();
        expectedClients.add(new Client("server"));
        expectedClients.add(new Client("hades"));
        expectedClients.add(new Client("aphrodite"));
        expectedClients.add(new Client("zeus"));
        expectedClients.add(new Client("ares"));
        expectedClients.add(new Client("apollo"));

        when(appConfig.getOpenvpnIndexFile()).thenReturn("src/test/resources/index.txt");

        //when
        List<Client> actualClients = new ArrayList<>();
        actualClients.add(new Client("server"));
        actualClients.add(new Client("hades"));
        linuxService.updateClientsWithCertificateInfo(actualClients);

        //then
        actualClients.forEach(System.out::println);

        Assert.assertEquals(expectedClients.size(), actualClients.size());
        for (int i = 0; i<expectedClients.size(); i++){
            Assert.assertEquals(expectedClients.get(i), actualClients.get(i));
        }

    }

    @Test
    public void testClientsUpdateFromIpp(){
        //given
        List<Client> expectedClients = new ArrayList<>();
        expectedClients.add(new Client("oldhades"));
        expectedClients.add(new Client("hades"));
        expectedClients.add(new Client("ares"));
        expectedClients.add(new Client("aphrodite"));
        expectedClients.add(new Client("zeus"));
        expectedClients.add(new Client("apollo"));

        when(appConfig.getOpenvpnIppFile()).thenReturn("src/test/resources/ipp.txt");

        //when
        ArrayList<Client> actualClients = new ArrayList<>();
        linuxService.updateClientsWithRoutingInfo(actualClients);

        //then
        actualClients.forEach(System.out::println);

        Assert.assertEquals(expectedClients.size(), actualClients.size());
        for (int i = 0; i<expectedClients.size(); i++){
            Assert.assertEquals(expectedClients.get(i).getCommonName(), actualClients.get(i).getCommonName());
        }

    }

}
