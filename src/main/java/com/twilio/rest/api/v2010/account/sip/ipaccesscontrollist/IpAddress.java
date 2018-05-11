/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.sip.ipaccesscontrollist;

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
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpAddress extends Resource {
    private static final long serialVersionUID = 118701358673463L;

    /**
     * Create a IpAddressReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @return IpAddressReader capable of executing the read
     */
    public static IpAddressReader reader(final String pathAccountSid, 
                                         final String pathIpAccessControlListSid) {
        return new IpAddressReader(pathAccountSid, pathIpAccessControlListSid);
    }

    /**
     * Create a IpAddressReader to execute read.
     * 
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @return IpAddressReader capable of executing the read
     */
    public static IpAddressReader reader(final String pathIpAccessControlListSid) {
        return new IpAddressReader(pathIpAccessControlListSid);
    }

    /**
     * Create a IpAddressCreator to execute create.
     * 
     * @param pathAccountSid The account_sid
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param friendlyName The friendly_name
     * @param ipAddress The ip_address
     * @return IpAddressCreator capable of executing the create
     */
    public static IpAddressCreator creator(final String pathAccountSid, 
                                           final String pathIpAccessControlListSid, 
                                           final String friendlyName, 
                                           final String ipAddress) {
        return new IpAddressCreator(pathAccountSid, pathIpAccessControlListSid, friendlyName, ipAddress);
    }

    /**
     * Create a IpAddressCreator to execute create.
     * 
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param friendlyName The friendly_name
     * @param ipAddress The ip_address
     * @return IpAddressCreator capable of executing the create
     */
    public static IpAddressCreator creator(final String pathIpAccessControlListSid, 
                                           final String friendlyName, 
                                           final String ipAddress) {
        return new IpAddressCreator(pathIpAccessControlListSid, friendlyName, ipAddress);
    }

    /**
     * Create a IpAddressFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     * @return IpAddressFetcher capable of executing the fetch
     */
    public static IpAddressFetcher fetcher(final String pathAccountSid, 
                                           final String pathIpAccessControlListSid, 
                                           final String pathSid) {
        return new IpAddressFetcher(pathAccountSid, pathIpAccessControlListSid, pathSid);
    }

    /**
     * Create a IpAddressFetcher to execute fetch.
     * 
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     * @return IpAddressFetcher capable of executing the fetch
     */
    public static IpAddressFetcher fetcher(final String pathIpAccessControlListSid, 
                                           final String pathSid) {
        return new IpAddressFetcher(pathIpAccessControlListSid, pathSid);
    }

    /**
     * Create a IpAddressUpdater to execute update.
     * 
     * @param pathAccountSid The account_sid
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     * @return IpAddressUpdater capable of executing the update
     */
    public static IpAddressUpdater updater(final String pathAccountSid, 
                                           final String pathIpAccessControlListSid, 
                                           final String pathSid) {
        return new IpAddressUpdater(pathAccountSid, pathIpAccessControlListSid, pathSid);
    }

    /**
     * Create a IpAddressUpdater to execute update.
     * 
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     * @return IpAddressUpdater capable of executing the update
     */
    public static IpAddressUpdater updater(final String pathIpAccessControlListSid, 
                                           final String pathSid) {
        return new IpAddressUpdater(pathIpAccessControlListSid, pathSid);
    }

    /**
     * Create a IpAddressDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     * @return IpAddressDeleter capable of executing the delete
     */
    public static IpAddressDeleter deleter(final String pathAccountSid, 
                                           final String pathIpAccessControlListSid, 
                                           final String pathSid) {
        return new IpAddressDeleter(pathAccountSid, pathIpAccessControlListSid, pathSid);
    }

    /**
     * Create a IpAddressDeleter to execute delete.
     * 
     * @param pathIpAccessControlListSid The ip_access_control_list_sid
     * @param pathSid The sid
     * @return IpAddressDeleter capable of executing the delete
     */
    public static IpAddressDeleter deleter(final String pathIpAccessControlListSid, 
                                           final String pathSid) {
        return new IpAddressDeleter(pathIpAccessControlListSid, pathSid);
    }

    /**
     * Converts a JSON String into a IpAddress object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return IpAddress object represented by the provided JSON
     */
    public static IpAddress fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAddress.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a IpAddress object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return IpAddress object represented by the provided JSON
     */
    public static IpAddress fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAddress.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final String ipAddress;
    private final String ipAccessControlListSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String uri;

    @JsonCreator
    private IpAddress(@JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("friendly_name")
                      final String friendlyName, 
                      @JsonProperty("ip_address")
                      final String ipAddress, 
                      @JsonProperty("ip_access_control_list_sid")
                      final String ipAccessControlListSid, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("date_updated")
                      final String dateUpdated, 
                      @JsonProperty("uri")
                      final String uri) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.ipAddress = ipAddress;
        this.ipAccessControlListSid = ipAccessControlListSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.uri = uri;
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
     * Returns The The unique id of the Account that responsible for this resource..
     * 
     * @return The unique id of the Account that responsible for this resource.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The A human readable descriptive text for this resource, up to 64
     * characters long..
     * 
     * @return A human readable descriptive text for this resource, up to 64
     *         characters long.
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The An IP address in dotted decimal notation from which you want to
     * accept traffic. Any SIP requests from this IP address will be allowed by
     * Twilio. IPv4 only supported today..
     * 
     * @return An IP address in dotted decimal notation from which you want to
     *         accept traffic. Any SIP requests from this IP address will be allowed
     *         by Twilio. IPv4 only supported today.
     */
    public final String getIpAddress() {
        return this.ipAddress;
    }

    /**
     * Returns The The ip_access_control_list_sid.
     * 
     * @return The ip_access_control_list_sid
     */
    public final String getIpAccessControlListSid() {
        return this.ipAccessControlListSid;
    }

    /**
     * Returns The The date that this resource was created, given as GMT in RFC 2822
     * format..
     * 
     * @return The date that this resource was created, given as GMT in RFC 2822
     *         format.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date that this resource was last updated, given as GMT in RFC
     * 2822 format..
     * 
     * @return The date that this resource was last updated, given as GMT in RFC
     *         2822 format.
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The URI for this resource, relative to https://api.twilio.com.
     * 
     * @return The URI for this resource, relative to https://api.twilio.com
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IpAddress other = (IpAddress) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(ipAddress, other.ipAddress) && 
               Objects.equals(ipAccessControlListSid, other.ipAccessControlListSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            friendlyName,
                            ipAddress,
                            ipAccessControlListSid,
                            dateCreated,
                            dateUpdated,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("friendlyName", friendlyName)
                          .add("ipAddress", ipAddress)
                          .add("ipAccessControlListSid", ipAccessControlListSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("uri", uri)
                          .toString();
    }
}