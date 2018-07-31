1) This is a spring boot application built on Maven 

2) You can import as maven project and run as mvn clean package on the path -- /xxx/xxx/test-app-report-tool to get the packed jar in target folder

3) Resources/config.xml has the beans for each instruction

<bean id="instruction1" class="com.java.reporting.tool.Instruction">
		<property name="entity" value="foo"></property>
		<property name="buysell" value="B"></property>
		<property name="agreedFx" value="0.50"></property>
		<property name="currency" value="SGP"></property>
		<property name="instDate" value="01 Jan 2016"></property>
		<property name="settleDate" value="02 Jan 2016"></property>
		<property name="units" value="200"></property>
		<property name="ppu" value="100.25"></property>
	</bean>
    
4) in the sspring boot application class, TestAppReportToolApplication - I load the beans from app context, iterate over each bean and process it to get the desired outputs

5) Util class is used for utility functions like printing the ranking, setting the correct settlement date.

6) Junits are in the test folder. I will attach a screenshot of the code coverage in my local workspace in the email.
