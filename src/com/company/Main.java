package com.company;

import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.EvaluationContext;
import dev.openfeature.sdk.MutableContext;
import dev.openfeature.sdk.OpenFeatureAPI;
import io.split.openfeature.SplitProvider;
import dev.openfeature.sdk.OpenFeatureAPI;
import io.split.openfeature.SplitProvider;
import io.split.client.SplitClient;
import io.split.client.SplitClientConfig;
import io.split.client.SplitFactoryBuilder;



public class Main {

    public static void main(String[] args) {
	// write your code here

        OpenFeatureAPI api = OpenFeatureAPI.getInstance();

        api.setProvider(new SplitProvider("SDK_KEY")); // put server side SDK key here
        Client client = api.getClient("CLIENT_NAME");

        EvaluationContext context = new MutableContext("user6"); // put user ID here
        String treatment = client.getStringValue("FLAG_NAME", "default", context); // put flag name and default
        System.out.println("Serving: "+treatment);
        if (treatment.equals("special")) {
            // insert code here to show on treatment
            System.out.println("""
 ___________ _____ _____ _____  ___   _    \s
/  ___| ___ \\  ___/  __ \\_   _|/ _ \\ | |   \s
\\ `--.| |_/ / |__ | /  \\/ | | / /_\\ \\| |   \s
 `--. \\  __/|  __|| |     | | |  _  || |   \s
/\\__/ / |   | |___| \\__/\\_| |_| | | || |____
\\____/\\_|   \\____/ \\____/\\___/\\_| |_/\\_____/
 """);


        } else if (treatment.equals("on")) {
            // insert code here to show on treatment
            System.out.println("""
  ______   .__   __.\s
 /  __  \\  |  \\ |  |\s
|  |  |  | |   \\|  |\s
|  |  |  | |  . `  |\s
|  `--'  | |  |\\   |\s
 \\______/  |__| \\__|\s
                    \s
                        """);

        } else if (treatment.equals("off")) {
            // insert code here to show off treatment
            System.out.println("""
 ___  _____ _____\s
/ _ \\|  ___|  ___|
| | | | |_  | |_  \s
| |_| |  _| |  _| \s
\\___/|_|   |_|   \s
                \s""");

        }

    }


}
