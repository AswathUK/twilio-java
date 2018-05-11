/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v1.service;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ChannelUpdater extends Updater<Channel> {
    private final String pathServiceSid;
    private final String pathSid;
    private String friendlyName;
    private String uniqueName;
    private String attributes;

    /**
     * Construct a new ChannelUpdater.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     */
    public ChannelUpdater(final String pathServiceSid, 
                          final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    /**
     * A human-readable name for the Channel. Optional..
     * 
     * @param friendlyName A human-readable name for the Channel.
     * @return this
     */
    public ChannelUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * A unique, addressable name for the Channel.  Optional..
     * 
     * @param uniqueName A unique, addressable name for the Channel.
     * @return this
     */
    public ChannelUpdater setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    /**
     * An optional metadata field you can use to store any data you wish. No
     * processing or validation is done on this field..
     * 
     * @param attributes An optional metadata field you can use to store any data
     *                   you wish.
     * @return this
     */
    public ChannelUpdater setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Channel
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Channel update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Channels/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Channel update failed: Unable to connect to server");
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

        return Channel.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
        }

        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }
    }
}