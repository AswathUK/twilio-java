/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.chat.v2.service.channel;

import com.twilio.base.Updater;
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

public class MessageUpdater extends Updater<Message> {
    private final String pathServiceSid;
    private final String pathChannelSid;
    private final String pathSid;
    private String body;
    private String attributes;
    private DateTime dateCreated;
    private DateTime dateUpdated;
    private String lastUpdatedBy;

    /**
     * Construct a new MessageUpdater.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @param pathSid The sid
     */
    public MessageUpdater(final String pathServiceSid, 
                          final String pathChannelSid, 
                          final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
        this.pathSid = pathSid;
    }

    /**
     * The optional message body string. You can also send structured data by
     * serializing it into a string. May be updated to empty string or `null`, will
     * be set as empty string as a result in this cases..
     * 
     * @param body The optional message body string.
     * @return this
     */
    public MessageUpdater setBody(final String body) {
        this.body = body;
        return this;
    }

    /**
     * The optional attributes metadata field you can use to store any data you
     * wish.  The string value must contain structurally valid JSON if specified..
     * 
     * @param attributes The optional attributes metadata field you can use to
     *                   store any data you wish.
     * @return this
     */
    public MessageUpdater setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * The optional ISO8601 time specifying the datetime the Message should be set
     * as being created..
     * 
     * @param dateCreated The optional ISO8601 time specifying the datetime the
     *                    Message should be set as being created.
     * @return this
     */
    public MessageUpdater setDateCreated(final DateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * The optional ISO8601 time specifying the datetime the Message should be set
     * as having been last updated..
     * 
     * @param dateUpdated The optional ISO8601 time specifying the datetime the
     *                    Message should be set as having been last updated.
     * @return this
     */
    public MessageUpdater setDateUpdated(final DateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    /**
     * Optional field to specify the Identity of the User that last updated the
     * Message (if relevant).
     * 
     * @param lastUpdatedBy Optional field to specify the Identity of the User that
     *                      last updated the Message
     * @return this
     */
    public MessageUpdater setLastUpdatedBy(final String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Message
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Message update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CHAT.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Channels/" + this.pathChannelSid + "/Messages/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Message update failed: Unable to connect to server");
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

        return Message.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (body != null) {
            request.addPostParam("Body", body);
        }

        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }

        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toString());
        }

        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toString());
        }

        if (lastUpdatedBy != null) {
            request.addPostParam("LastUpdatedBy", lastUpdatedBy);
        }
    }
}