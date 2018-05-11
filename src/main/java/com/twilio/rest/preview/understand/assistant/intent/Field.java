/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.understand.assistant.intent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Field extends Resource {
    private static final long serialVersionUID = 209912298498000L;

    /**
     * Create a FieldFetcher to execute fetch.
     * 
     * @param pathAssistantSid The assistant_sid
     * @param pathIntentSid The intent_sid
     * @param pathSid The sid
     * @return FieldFetcher capable of executing the fetch
     */
    public static FieldFetcher fetcher(final String pathAssistantSid, 
                                       final String pathIntentSid, 
                                       final String pathSid) {
        return new FieldFetcher(pathAssistantSid, pathIntentSid, pathSid);
    }

    /**
     * Create a FieldReader to execute read.
     * 
     * @param pathAssistantSid The assistant_sid
     * @param pathIntentSid The intent_sid
     * @return FieldReader capable of executing the read
     */
    public static FieldReader reader(final String pathAssistantSid, 
                                     final String pathIntentSid) {
        return new FieldReader(pathAssistantSid, pathIntentSid);
    }

    /**
     * Create a FieldCreator to execute create.
     * 
     * @param pathAssistantSid The assistant_sid
     * @param pathIntentSid The intent_sid
     * @param fieldType The unique name or sid of the FieldType
     * @param uniqueName A user-provided string that uniquely identifies this
     *                   resource as an alternative to the sid. Unique up to 64
     *                   characters long.
     * @return FieldCreator capable of executing the create
     */
    public static FieldCreator creator(final String pathAssistantSid, 
                                       final String pathIntentSid, 
                                       final String fieldType, 
                                       final String uniqueName) {
        return new FieldCreator(pathAssistantSid, pathIntentSid, fieldType, uniqueName);
    }

    /**
     * Create a FieldDeleter to execute delete.
     * 
     * @param pathAssistantSid The assistant_sid
     * @param pathIntentSid The intent_sid
     * @param pathSid The sid
     * @return FieldDeleter capable of executing the delete
     */
    public static FieldDeleter deleter(final String pathAssistantSid, 
                                       final String pathIntentSid, 
                                       final String pathSid) {
        return new FieldDeleter(pathAssistantSid, pathIntentSid, pathSid);
    }

    /**
     * Converts a JSON String into a Field object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Field object represented by the provided JSON
     */
    public static Field fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Field.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Field object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Field object represented by the provided JSON
     */
    public static Field fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Field.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String fieldType;
    private final String intentSid;
    private final String assistantSid;
    private final String sid;
    private final String uniqueName;
    private final URI url;

    @JsonCreator
    private Field(@JsonProperty("account_sid")
                  final String accountSid, 
                  @JsonProperty("date_created")
                  final String dateCreated, 
                  @JsonProperty("date_updated")
                  final String dateUpdated, 
                  @JsonProperty("field_type")
                  final String fieldType, 
                  @JsonProperty("intent_sid")
                  final String intentSid, 
                  @JsonProperty("assistant_sid")
                  final String assistantSid, 
                  @JsonProperty("sid")
                  final String sid, 
                  @JsonProperty("unique_name")
                  final String uniqueName, 
                  @JsonProperty("url")
                  final URI url) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.fieldType = fieldType;
        this.intentSid = intentSid;
        this.assistantSid = assistantSid;
        this.sid = sid;
        this.uniqueName = uniqueName;
        this.url = url;
    }

    /**
     * Returns The The unique ID of the Account that created this Field..
     * 
     * @return The unique ID of the Account that created this Field.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The date that this resource was created.
     * 
     * @return The date that this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date that this resource was last updated.
     * 
     * @return The date that this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The Field Type of this field. Can be the Field Type unique_name
     * or the Field Type sid..
     * 
     * @return The Field Type of this field. Can be the Field Type unique_name or
     *         the Field Type sid.
     */
    public final String getFieldType() {
        return this.fieldType;
    }

    /**
     * Returns The The unique ID of the Intent associated with this Field..
     * 
     * @return The unique ID of the Intent associated with this Field.
     */
    public final String getIntentSid() {
        return this.intentSid;
    }

    /**
     * Returns The The unique ID of the parent Assistant..
     * 
     * @return The unique ID of the parent Assistant.
     */
    public final String getAssistantSid() {
        return this.assistantSid;
    }

    /**
     * Returns The A 34 character string that uniquely identifies this resource..
     * 
     * @return A 34 character string that uniquely identifies this resource.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The A user-provided string that uniquely identifies this resource as
     * an alternative to the sid. Unique up to 64 characters long..
     * 
     * @return A user-provided string that uniquely identifies this resource as an
     *         alternative to the sid. Unique up to 64 characters long.
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Field other = (Field) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(fieldType, other.fieldType) && 
               Objects.equals(intentSid, other.intentSid) && 
               Objects.equals(assistantSid, other.assistantSid) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(uniqueName, other.uniqueName) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            fieldType,
                            intentSid,
                            assistantSid,
                            sid,
                            uniqueName,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("fieldType", fieldType)
                          .add("intentSid", intentSid)
                          .add("assistantSid", assistantSid)
                          .add("sid", sid)
                          .add("uniqueName", uniqueName)
                          .add("url", url)
                          .toString();
    }
}