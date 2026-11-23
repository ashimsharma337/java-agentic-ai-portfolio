package com.ashim.main;


import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;


public class LaunchLC4J {
	
	static ChatModel model = OpenAiChatModel.builder()
	        .apiKey(System.getenv("OPENAI_API_KEY"))
	        .modelName("gpt-4o-mini")
	        .build();

	public static void main(String[] args) {
		
			SystemMessage systemMessage = SystemMessage.systemMessage(""
					+ "Act like Java trainer and aswer only Java programming related queries if its out of Java and software please dny and tell"
					+ "i can't answer your query as i m only into Java and tech");
			
			//UserMessage userQuestion = UserMessage.userMessage("What is Java tell in one sentence?");
			//ßUserMessage userQuestion = UserMessage.userMessage("tell me about fifa worldcup");
			
			
			for(int i=0;i<3;i++)
			{
				UserMessage userQuestion = UserMessage.userMessage("suggest me only one  ai java live course name");
				withExtraParam(1.0, userQuestion);

			}
		
		
//		ChatRequest chatRequest = ChatRequest.builder()
//		.messages(userQuestion)
//		.maxOutputTokens(30)
//		.temperature(1.0)
//		.build();
		
		
//		String reply = model.chat(chatRequest).aiMessage().text();
//		System.out.println(reply);
		
//		System.out.println("only answer");
//		String answer = model.chat("Tell me who is Navin Reddy Java Telusko");
//		System.out.println(answer);
//		
//		System.out.println("answer with metadata");
//		
//		ChatResponse response = model.chat(systemMessage, userQuestion);
//		System.out.println(response.aiMessage().text());
//		System.out.println("input token count "+response.tokenUsage().inputTokenCount());
//		System.out.println("output token count "+response.tokenUsage().outputTokenCount());
//		System.out.println("totaltoken count "+response.tokenUsage().totalTokenCount());
		
//		TeluskoSupport teluskoSupport = AiServices.create(TeluskoSupport.class, model);
//		String answer = teluskoSupport.explain("Dependency Injection");
//		System.out.println(answer);
	}
	
	static void withExtraParam(double temperature, UserMessage userQuestion) {
		
		ChatRequest chatRequest = ChatRequest.builder()
		.messages(userQuestion)
		.maxOutputTokens(30)
		.temperature(temperature)
		.build();
		
		
		String reply = model.chat(chatRequest).aiMessage().text();
		System.out.println(reply);
	}

}
