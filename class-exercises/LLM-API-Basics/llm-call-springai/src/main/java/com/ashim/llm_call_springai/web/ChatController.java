package com.ashim.llm_call_springai.web;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ChatController {
	
	private final OpenAiChatModel chatModel;
	
	private final ChatClient chatClient;
	
	public ChatController(OpenAiChatModel chatModel) {
		
		this.chatModel=chatModel;
		this.chatClient=ChatClient.create(chatModel);
	}
	
	
	@GetMapping("/ask")
	public String askModel(@RequestParam String message) {
		
		return chatModel.call(message);
	}
	
	@GetMapping("/chat")
	public String chatModel(@RequestParam String message) {
		
		return chatClient.prompt()
		.system("You are a Java expert. Keep answer short in 2 lines and also answer only tech related question")
		.user(message)
		.call()
		.content();
	}

}
