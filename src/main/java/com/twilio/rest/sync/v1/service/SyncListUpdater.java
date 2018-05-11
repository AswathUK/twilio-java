/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SyncListUpdater extends Updater<SyncList> {
    private final String pathServiceSid;
    private final String pathSid;
    private Integer ttl;

    /**
     * Construct a new SyncListUpdater.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     */
    public SyncListUpdater(final String pathServiceSid, 
                           final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    /**
     * Time-to-live of this List in seconds, defaults to no expiration. In the range
     * [1, 31 536 000 (1 year)], or 0 for infinity..
     * 
     * @param ttl Time-to-live of this List in seconds, defaults to no expiration.
     * @return this
     */
    public SyncListUpdater setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated SyncList
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncList update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Lists/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncList update failed: Unable to connect to server");
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

        return SyncList.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }
    }
}