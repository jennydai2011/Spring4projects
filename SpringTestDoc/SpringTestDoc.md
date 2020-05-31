# Steps:
1. Create Spring boot project
2. Create Controller and service
3. run spring boot application
4. add/run mock mvc test methods
5. @SpringBootTest class add @AutoConfigureRestDocs
6. @SpringBootTestclass @AutoConfigureRestDocs(outputDir = "target/generated-snippets")
7. @SpringBootTest class add @ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
8. @BeforeEach
@BeforeEach
	public void setup(WebApplicationContext webApplicationContext,
					  RestDocumentationContextProvider restDocumentationContextProvider){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentationContextProvider))
				.build();...
	}
9. test method add andDo(print()) and 
.andDo(document("{methodName}",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint())));

10. pom.xml add
<dependency>
			<groupId>org.springframework.restdocs</groupId>
			<artifactId>spring-restdocs-mockmvc</artifactId>
		</dependency>
11.pom.xml plug-in add
<plugin>
				<groupId>org.asciidoctor</groupId>
				<artifactId>asciidoctor-maven-plugin</artifactId>
				<version>1.6.0</version>
				<executions>
					<execution>
						<id>generate-docs</id>
						<phase>package</phase>
						<goals>
							<goal>process-asciidoc</goal>
						</goals>
						<configuration>
							<backend>html</backend>
							<doctype>book</doctype>
							<attributes>
								<snippets>
									${project.build.directory}/generated-snippets
								</snippets>
							</attributes>
						</configuration>
					</execution>
				</executions>
			</plugin>
	check generated adoc files for each method
12. add src/main/asciidoc folder
13. create index.adoc under asciidoc folder
14. add content to index.adoc
15. run test and check generated html file