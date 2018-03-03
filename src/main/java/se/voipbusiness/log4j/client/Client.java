package se.voipbusiness.log4j.client;

import java.net.URL;

public interface Client {
    void send(URL webhookUrl, String payload);
}
