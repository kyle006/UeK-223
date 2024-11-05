package ch.zli.m223.controller;

import ch.zli.m223.service.EntryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/statistics")
public class StatisticsController {

    @Inject
    EntryService entryService;

    @GET
    @Path("/time-summaries")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getTimeSummaries() {
        Map<LocalDate, Duration> summaries = entryService.getTimeSummaries();
        return summaries.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> formatDuration(entry.getValue())
                ));
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}