package StepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {

		StepDefinations stepDef = new StepDefinations();

		if (StepDefinations.place_id == null) {

			stepDef.add_place_payload_with("Sanghamitra", "English", "A Ward");
			stepDef.user_calls_with_http_request("AddPlaceAPI", "POST");
			stepDef.verify_place_id_created_maps_to_using("Sanghamitra", "GetPlaceAPI");
		}
	}
}
