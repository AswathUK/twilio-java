/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.monitor.v1;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

public class EventReader extends Reader<Event> {
    private String actorSid;
    private String eventType;
    private String resourceSid;
    private String sourceIpAddress;
    private DateTime startDate;
    private DateTime endDate;

    /**
     * The actor_sid.
     * 
     * @param actorSid The actor_sid
     * @return this
     */
    public EventReader setActorSid(final String actorSid) {
        this.actorSid = actorSid;
        return this;
    }

    /**
     * The event_type.
     * 
     * @param eventType The event_type
     * @return this
     */
    public EventReader setEventType(final String eventType) {
        this.eventType = eventType;
        return this;
    }

    /**
     * The resource_sid.
     * 
     * @param resourceSid The resource_sid
     * @return this
     */
    public EventReader setResourceSid(final String resourceSid) {
        this.resourceSid = resourceSid;
        return this;
    }

    /**
     * The source_ip_address.
     * 
     * @param sourceIpAddress The source_ip_address
     * @return this
     */
    public EventReader setSourceIpAddress(final String sourceIpAddress) {
        this.sourceIpAddress = sourceIpAddress;
        return this;
    }

    /**
     * The start_date.
     * 
     * @param startDate The start_date
     * @return this
     */
    public EventReader setStartDate(final DateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The end_date.
     * 
     * @param endDate The end_date
     * @return this
     */
    public EventReader setEndDate(final DateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Event ResourceSet
     */
    @Override
    public ResourceSet<Event> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Event ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Event> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.MONITOR.toString(),
            "/v1/Events",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     * 
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Event ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Event> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Event> nextPage(final Page<Event> page, 
                                final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.MONITOR.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Event> previousPage(final Page<Event> page, 
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.MONITOR.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Event Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Event> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Event read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Page.fromJson(
            "events",
            response.getContent(),
            Event.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (actorSid != null) {
            request.addQueryParam("ActorSid", actorSid);
        }

        if (eventType != null) {
            request.addQueryParam("EventType", eventType);
        }

        if (resourceSid != null) {
            request.addQueryParam("ResourceSid", resourceSid);
        }

        if (sourceIpAddress != null) {
            request.addQueryParam("SourceIpAddress", sourceIpAddress);
        }

        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toString());
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}