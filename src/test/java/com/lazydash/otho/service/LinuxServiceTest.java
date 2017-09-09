package com.lazydash.otho.service;


import com.lazydash.otho.config.AppConfig;
import com.lazydash.otho.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        List<Client> clients = linuxService.getConnectedClients();

        //then
        clients.forEach(System.out::println);

    }
}
