package com.vasiliskardaras.soap_provider;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;
import org.springframework.ws.soap.security.callback.CleanupCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class CustomSecurityCallbackHandler implements CallbackHandler  {

    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof WSPasswordCallback pc) {
                validatePasswordCallback(pc);
            } else if (callback instanceof CleanupCallback) {
//                log.info("Cleanup Callback");
            } else {
                throw new UnsupportedCallbackException(callback, "Unsupported callback type");
            }
        }
    }

    private void validatePasswordCallback(WSPasswordCallback pc) {
        System.out.println("validatePasswordCallback");
        String identifier = pc.getIdentifier() != null ? pc.getIdentifier() : "";
        System.out.println("identifier = " + identifier);
//        pc.setPassword(getPassword(identifier));
        pc.setPassword("pass");
    }
}
