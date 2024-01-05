package com.company;

import dev.openfeature.sdk.ImmutableContext;
import dev.openfeature.sdk.OpenFeatureAPI;
import io.github.cdimascio.dotenv.Dotenv;
import io.split.openfeature.SplitProvider;

import java.util.concurrent.RejectedExecutionException;

public class Main {

    // keys in .env
    public static final String ENV_SPLIT_API_KEY = "SPLIT_API_KEY";
    public static final String ENV_FEATURE_FLAG_NAME = "FEATURE_FLAG_NAME";
    public static final String ENV_TARGET_KEY = "TARGET_KEY";
    public static final String ENV_TARGET_USER = "TARGET_USER";

    public static final String CLIENT_NAME = "OpenFeature-Java-Example";
    public static final String DEFAULT_VALUE = "default";

    public static void main(String... args) {
        // Load environment
        var dotenv = Dotenv.load();

        // Setup split and openfeature
        var splitProvider = new SplitProvider(dotenv.get(ENV_SPLIT_API_KEY));
        var api = OpenFeatureAPI.getInstance();
        api.setProvider(splitProvider);

        // Setup default evaluation context, to make sure we always have one set avoiding errors
        var defaultContext = new ImmutableContext(dotenv.get(ENV_TARGET_KEY));
        api.setEvaluationContext(defaultContext);

        // Get client for interaction
        var client = api.getClient(CLIENT_NAME);

        // Query feature flag
        var context = new ImmutableContext(dotenv.get(ENV_TARGET_USER));
        var treatment = client.getStringValue(dotenv.get(ENV_FEATURE_FLAG_NAME), DEFAULT_VALUE, context);

        System.out.println("""
                \n
                _|_|_|_|_|                                  _|                                            _|     \s
                    _|      _|  _|_|    _|_|      _|_|_|  _|_|_|_|  _|_|_|  _|_|      _|_|    _|_|_|    _|_|_|_| \s
                    _|      _|_|      _|_|_|_|  _|    _|    _|      _|    _|    _|  _|_|_|_|  _|    _|    _|     \s
                    _|      _|        _|        _|    _|    _|      _|    _|    _|  _|        _|    _|    _|     \s
                    _|      _|          _|_|_|    _|_|_|      _|_|  _|    _|    _|    _|_|_|  _|    _|      _|_| \s
                """);

        System.out.println("Serving " + treatment);

        switch (treatment) {
            case "blue" -> System.out.println("doing something blue...");
            case "orange" -> System.out.println("doing something orange...");
            case "default" -> System.out.println("handling fallback...");
            default -> throw new IllegalStateException("Unexpected value: " + treatment);
        }

        System.out.println("""
                \n
                _|_|_|                                 \s
                _|    _|    _|_|    _|_|_|      _|_|   \s
                _|    _|  _|    _|  _|    _|  _|_|_|_| \s
                _|    _|  _|    _|  _|    _|  _|       \s
                _|_|_|      _|_|    _|    _|    _|_|_| \s
                \n""");
    }
}
