package com.example.video.call.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
 
@Component
public class SignalingHandler extends TextWebSocketHandler {

   
    private final Map<String, CopyOnWriteArraySet<WebSocketSession>> rooms = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Map<String, String> data = parseMessage(payload);

        String type = data.get("type");

        if ("join".equals(type)) {
            String roomId = data.get("roomId");
            rooms.putIfAbsent(roomId, new CopyOnWriteArraySet<>());
            rooms.get(roomId).add(session);
        } else if ("offer".equals(type) || "answer".equals(type) || "candidate".equals(type)) {
            String roomId = data.get("roomId");
            relayMessageToRoom(roomId, session, message);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        rooms.forEach((roomId, sessions) -> {
            if (sessions.remove(session) && sessions.isEmpty()) {
                rooms.remove(roomId);
            }
        });
    }

    private void relayMessageToRoom(String roomId, WebSocketSession sender, TextMessage message) {
        rooms.getOrDefault(roomId, new CopyOnWriteArraySet<>())
             .stream()
             .filter(session -> !session.getId().equals(sender.getId()))
             .forEach(session -> {
                 try {
                     session.sendMessage(message);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             });
    }

    private Map<String, String> parseMessage(String payload) {
        // This is a simple parser. You might want to use JSON parsing in production.
        Map<String, String> data = new ConcurrentHashMap<>();
        for (String pair : payload.split("&")) {
            String[] keyValue = pair.split("=");
            data.put(keyValue[0], keyValue[1]);
        }
        return data;
    }
}
