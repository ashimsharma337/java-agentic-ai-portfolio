package com.ashim.main;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class LaunchOpenSDK2 {
	
	static OpenAIClient client = OpenAIOkHttpClient.builder()
			.apiKey(System.getenv("OPENAI_API_KEY"))
			.build();


	public static void main(String[] args) {
		
		// temperature is about creativity and randomness
//		In AI models—especially large language models 
//		(LLMs)—temperature is a parameter that controls the randomness and predictability of the model's output. 
//		Lower values make responses more focused and consistent, while higher values make them more varied and creative
		
		
		String question = "suggest me java ai course names for live batch";
		
		
		System.out.println("Temperature 0.0");
		for (int i=0; i<3; i++) {
			System.out.println(i + " : " +withTemperature(question, 0.0));
		}
		
		System.out.println("Temperature 0.8");
		for (int i=0; i<3; i++) {
			System.out.println(i + " : " +withTemperature(question, 0.8));
		}
		
		System.out.println("Temperature 1.0");
		for (int i=0; i<3; i++) {
			System.out.println(i + " : " +withTemperature(question, 1.0));
		}
		
	}
	
	public static String withTemperature(String question, double temperature) {
		
		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
				.model("gpt-5.4-mini")
				.addSystemMessage("Act like java and AI tech expert and answer queries in one line and don't answer anything other than tech")
				.addUserMessage(question)
				.temperature(temperature)
				.maxCompletionTokens(25)
				.build();
		
		return client.chat()
				.completions()
				.create(params)
				.choices()
				.get(0)
				.message()
				.content()
				.orElse("");
	}

}
