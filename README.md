# Java Agentic AI Portfolio

This repository is my learning portfolio for a Java Agentic AI course. It keeps class exercises separate from larger projects so each piece of work is easy to find, build, and revisit.

## Repository layout

```text
java-agentic-ai-portfolio/
├── class-exercises/       # Course exercises and experiments
│   └── LLM-API-Basics/    # Exercises about working with LLM APIs
│       └── first-llm-call/
├── projects/              # Larger, standalone portfolio projects
├── .gitignore
└── README.md
```

### Class exercises

Group exercises by course topic under [`class-exercises/`](./class-exercises/), then put each exercise in its own folder inside the topic. Keep each exercise's source code and build file together. For example:

```text
class-exercises/
├── LLM-API-Basics/
│   ├── first-llm-call/
│   └── another-llm-exercise/
└── another-topic/
    └── exercise-name/
```

### Projects

Put each larger project in its own descriptive subfolder under [`projects/`](./projects/). A project should include its own build configuration and a README with its purpose and run instructions.

## Build an exercise or project

Each Maven exercise or project is self-contained. From its folder, run:

```bash
mvn test
```

To package it:

```bash
mvn package
```

Use Java and Maven versions required by the individual module's build file.

## API keys and local configuration

Do not commit API keys, `.env` files, or other credentials. Set required values such as `OPENAI_API_KEY` in your local shell or IDE run configuration. The root `.gitignore` excludes common local secret files and Java build output.
