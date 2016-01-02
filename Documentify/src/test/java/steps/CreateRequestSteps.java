package steps;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.*;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import action.MockDataLoaderActionBean;
import documentify.action.RequestFormActionBean;
import documentify.model.Request;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockHttpSession;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
public class CreateRequestSteps extends JUnitStories {
	
	private static MockServletContext mockContext;
	private static MockHttpSession mockSession;
	
	
	Request request;
	@When("a Title is Test_Request1, Description is 'Test_Desc', Request Date is '01/01/2014', Due Date is '01/01/2017', Points Avilable is '28', Priority is 'Low', Status is 'Open', Requested By 'Russ', Comments is 'Test_Comment'")
	public void whenATitleIsTest_Request1DescriptionIsTest_DescRequestDateIs01012014DueDateIs01012017PointsAvilableIs28PriorityIsLowStatusIsOpenRequestedByRussCommentsIsTest_Comment(){
		 System.out.println("Parsing request values");
	}
	
	@Then("a simple confirmation message is returned")
	public void thenASimpleConfirmationMessageIsReturned(){
		 System.out.println("Then!!"); 
	}
	@Given("a task of creating a new request")
	public void givenATaskOfCreatingANewRequest() throws Exception{
		setup();
		MockRoundtrip trip = new MockRoundtrip(mockContext, RequestFormActionBean.class, mockSession);
		trip.setParameter("request.id", "100");
		trip.setParameter("request.dateOfRequest", "01/01/2014");
		trip.setParameter("pointsWorth", "99");
		trip.setParameter("request.comments", "New Request");
		trip.setParameter("request.assignedPriority", "Low");
		trip.setParameter("request.requester", "Russ");
		trip.setParameter("request.reviewDate", "15/01/2017");
		trip.setParameter("request.status", "Open");
		trip.setParameter("request.requestTitle", "New Request Name");
		trip.setParameter("request.requestDesc", "No more info");
		System.out.println("New Request Object");
		request = new Request();
		 
	}
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("steps/CreateRequest.story");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Configuration configuration() {
	    return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}
	 
	@Override
	public List<CandidateSteps> candidateSteps() {
	    return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}
	
	@Override
	@Test
	public void run() throws Throwable {
	    super.run();
	}
	
	private void setup() throws Exception{
		// Context and Session Setup
		mockContext = new MockServletContext("testContext");
		Map<String,String> params = new HashMap<>();
		params.put("ActionResolver.Packages", "documentify.action");
		params.put("Extension.Packages", "documentify.ext, org.stripesstuff.stripersist");
		mockContext.addFilter(StripesFilter.class, "StripesFilter", params);
		mockContext.setServlet(DispatcherServlet.class, "DispatcherServlet", null);
		mockSession = new MockHttpSession(mockContext);
	}

}