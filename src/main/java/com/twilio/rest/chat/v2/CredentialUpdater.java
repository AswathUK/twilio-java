/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.chat.v2;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class CredentialUpdater extends Updater<Credential> {
    private final String pathSid;
    private String friendlyName;
    private String certificate;
    private String privateKey;
    private Boolean sandbox;
    private String apiKey;
    private String secret;

    /**
     * Construct a new CredentialUpdater.
     * 
     * @param pathSid The sid
     */
    public CredentialUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Friendly name for stored credential.
     * 
     * @param friendlyName Friendly name for stored credential
     * @return this
     */
    public CredentialUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * [APN only] URL encoded representation of the certificate, e.g.
     * `-----BEGIN CERTIFICATE-----
     * MIIFnTCCBIWgAwIBAgIIAjy9H849+E8wDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV.....A==
     * -----END CERTIFICATE-----`.
     * 
     * @param certificate [APN only] URL encoded representation of the certificate,
     *                    e.
     * @return this
     */
    public CredentialUpdater setCertificate(final String certificate) {
        this.certificate = certificate;
        return this;
    }

    /**
     * [APN only] URL encoded representation of the private key, e.g.
     * `-----BEGIN RSA PRIVATE KEY-----
     * MIIEpQIBAAKCAQEAuyf/lNrH9ck8DmNyo3fGgvCI1l9s+cmBY3WIz+cUDqmxiieR.
     * -----END RSA PRIVATE KEY-----`.
     * 
     * @param privateKey [APN only] URL encoded representation of the private key,
     *                   e.
     * @return this
     */
    public CredentialUpdater setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    /**
     * [APN only] use this credential for sending to production or sandbox APNs
     * (string `true` or `false`).
     * 
     * @param sandbox [APN only] use this credential for sending to production or
     *                sandbox APNs
     * @return this
     */
    public CredentialUpdater setSandbox(final Boolean sandbox) {
        this.sandbox = sandbox;
        return this;
    }

    /**
     * [GCM only] This is the "API key" for project from Google Developer console
     * for your GCM Service application credential.
     * 
     * @param apiKey [GCM only] This is the "API key" for project from Google
     *               Developer console for your GCM Service application credential
     * @return this
     */
    public CredentialUpdater setApiKey(final String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * [FCM only] This is the "Server key" of your project from Firebase console
     * under Settings / Cloud messaging..
     * 
     * @param secret [FCM only] This is the "Server key" of your project from
     *               Firebase console under Settings / Cloud messaging.
     * @return this
     */
    public CredentialUpdater setSecret(final String secret) {
        this.secret = secret;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Credential
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Credential update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CHAT.toString(),
            "/v2/Credentials/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Credential update failed: Unable to connect to server");
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

        return Credential.fromJson(response.getStream(), client.getObjectMapper());
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

        if (certificate != null) {
            request.addPostParam("Certificate", certificate);
        }

        if (privateKey != null) {
            request.addPostParam("PrivateKey", privateKey);
        }

        if (sandbox != null) {
            request.addPostParam("Sandbox", sandbox.toString());
        }

        if (apiKey != null) {
            request.addPostParam("ApiKey", apiKey);
        }

        if (secret != null) {
            request.addPostParam("Secret", secret);
        }
    }
}