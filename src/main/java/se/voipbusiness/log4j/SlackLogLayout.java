package se.voipbusiness.log4j;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/*
curl -X POST -d '{"text": ":warning:  Vårdfaktura has thrown an Exception", "channel": "#bot-system",
"username": "vfaktura", "icon_emoji": ":gradle:"}' -H "Content-Type: application/json"
https://hooks.slack.com/services/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
*/

public class SlackLogLayout extends PatternLayout {

    @Override
    public String format(LoggingEvent event){

        String msg = (String)event.getMessage();

        StringBuffer sb = new StringBuffer();

        String msgIcon =(String)event.getProperty("msgIcon");
        String chan =(String)event.getProperty("chan");
        String user = (String)event.getProperty("user");
        String icon = (String)event.getProperty("icon");

        sb.append("{\"text\": \"");
        sb.append(msgIcon + " " + msg + "\", ");
        sb.append("\"channel\": " + "\" " + chan + "\", ");
        sb.append("\"username\": " + "\" " + user + "\", ");
        sb.append("\"icon_emoji\": " + "\"" + icon + "\"}");

        return sb.toString();
    }
}
