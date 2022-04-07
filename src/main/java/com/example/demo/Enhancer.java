package com.example.demo;

import com.google.cloud.logging.LoggingEnhancer;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.LoggingEnhancer;


// Add / update additional fields to the log entry

public class Enhancer implements LoggingEnhancer {

    @Override
    public void enhanceLogEntry(LogEntry.Builder logEntry) {
        // add additional labels
        logEntry.addLabel("test-label-1", "test-value-1");
    }

}