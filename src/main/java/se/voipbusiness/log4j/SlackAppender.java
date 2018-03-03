package se.voipbusiness.log4j;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import se.voipbusiness.log4j.client.OkHttp3Client;

import java.net.MalformedURLException;
import java.net.URL;

public class SlackAppender extends AppenderSkeleton {

    private OkHttp3Client httpClient = new OkHttp3Client();

    String msgIcon = ":warning:";
    String msg= "Empty Message";
    String chan = "";
    String user = "Test-User";
    String icon = "earth_americas:";

    public String getMsgIcon() {
        return msgIcon;
    }

    public void setMsgIcon(String msgIcon) {
        this.msgIcon = msgIcon;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getChan() {
        return chan;
    }

    public void setChan(String chan) {
        this.chan = chan;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    @Override
    protected void append(LoggingEvent event) {

        event.setProperty("msgIcon", this.msgIcon);
        event.setProperty("chan", this.chan);
        event.setProperty("user", this.user);
        event.setProperty("icon", this.icon);

        System.out.println(event.getLevel() + " " + layout.format(event));

        URL url = null;
        try {
            url = new URL("https://hooks.slack.com/services/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");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        httpClient.send(url, layout.format(event));

    }
}