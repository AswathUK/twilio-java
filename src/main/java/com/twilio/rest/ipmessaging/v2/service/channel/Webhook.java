/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v2.service.channel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook extends Resource {
    private static final long serialVersionUID = 142993163058456L;

    public enum Type {
        WEBHOOK("webhook"),
        TRIGGER("trigger"),
        STUDIO("studio");

        private final String value;

        private Type(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Type from a string.
         * @param value string value
         * @return generated Type
         */
        @JsonCreator
        public static Type forValue(final String value) {
            return Promoter.enumFromString(value, Type.values());
        }
    }

    public enum Method {
        GET("GET"),
        POST("POST");

        private final String value;

        private Method(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Method from a string.
         * @param value string value
         * @return generated Method
         */
        @JsonCreator
        public static Method forValue(final String value) {
            return Promoter.enumFromString(value, Method.values());
        }
    }

    /**
     * Create a WebhookReader to execute read.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @return WebhookReader capable of executing the read
     */
    public static WebhookReader reader(final String pathServiceSid, 
                                       final String pathChannelSid) {
        return new WebhookReader(pathServiceSid, pathChannelSid);
    }

    /**
     * Create a WebhookFetcher to execute fetch.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @param pathSid The sid
     * @return WebhookFetcher capable of executing the fetch
     */
    public static WebhookFetcher fetcher(final String pathServiceSid, 
                                         final String pathChannelSid, 
                                         final String pathSid) {
        return new WebhookFetcher(pathServiceSid, pathChannelSid, pathSid);
    }

    /**
     * Create a WebhookCreator to execute create.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @param type The type
     * @return WebhookCreator capable of executing the create
     */
    public static WebhookCreator creator(final String pathServiceSid, 
                                         final String pathChannelSid, 
                                         final Webhook.Type type) {
        return new WebhookCreator(pathServiceSid, pathChannelSid, type);
    }

    /**
     * Create a WebhookUpdater to execute update.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @param pathSid The sid
     * @return WebhookUpdater capable of executing the update
     */
    public static WebhookUpdater updater(final String pathServiceSid, 
                                         final String pathChannelSid, 
                                         final String pathSid) {
        return new WebhookUpdater(pathServiceSid, pathChannelSid, pathSid);
    }

    /**
     * Create a WebhookDeleter to execute delete.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @param pathSid The sid
     * @return WebhookDeleter capable of executing the delete
     */
    public static WebhookDeleter deleter(final String pathServiceSid, 
                                         final String pathChannelSid, 
                                         final String pathSid) {
        return new WebhookDeleter(pathServiceSid, pathChannelSid, pathSid);
    }

    /**
     * Converts a JSON String into a Webhook object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Webhook object represented by the provided JSON
     */
    public static Webhook fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Webhook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Webhook object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Webhook object represented by the provided JSON
     */
    public static Webhook fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Webhook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String channelSid;
    private final String type;
    private final URI url;
    private final Map<String, Object> configuration;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;

    @JsonCreator
    private Webhook(@JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("service_sid")
                    final String serviceSid, 
                    @JsonProperty("channel_sid")
                    final String channelSid, 
                    @JsonProperty("type")
                    final String type, 
                    @JsonProperty("url")
                    final URI url, 
                    @JsonProperty("configuration")
                    final Map<String, Object> configuration, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_updated")
                    final String dateUpdated) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.channelSid = channelSid;
        this.type = type;
        this.url = url;
        this.configuration = configuration;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The service_sid.
     * 
     * @return The service_sid
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The channel_sid.
     * 
     * @return The channel_sid
     */
    public final String getChannelSid() {
        return this.channelSid;
    }

    /**
     * Returns The The type.
     * 
     * @return The type
     */
    public final String getType() {
        return this.type;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The configuration.
     * 
     * @return The configuration
     */
    public final Map<String, Object> getConfiguration() {
        return this.configuration;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Webhook other = (Webhook) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(channelSid, other.channelSid) && 
               Objects.equals(type, other.type) && 
               Objects.equals(url, other.url) && 
               Objects.equals(configuration, other.configuration) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            channelSid,
                            type,
                            url,
                            configuration,
                            dateCreated,
                            dateUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("channelSid", channelSid)
                          .add("type", type)
                          .add("url", url)
                          .add("configuration", configuration)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .toString();
    }
}