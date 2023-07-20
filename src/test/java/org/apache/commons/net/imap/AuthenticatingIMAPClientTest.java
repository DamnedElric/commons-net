/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.net.imap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AuthenticatingIMAPClientTest {

    @ParameterizedTest(name = "auth method for method {1} is `{0}`")
    @MethodSource("authMethods")
    public void getAuthName(final String expectedAuthMethodName, final AuthenticatingIMAPClient.AUTH_METHOD authMethod) {
        assertEquals(expectedAuthMethodName, authMethod.getAuthName());
    }

    @Test
    @Disabled
    public void auth() {
        fail("Not yet implemented");
    }

    @Test
    @Disabled
    public void authenticate() {
        fail("Not yet implemented");
    }

    private static Stream<Arguments> authMethods() {
        return Stream.of(
            Arguments.of("PLAIN", AuthenticatingIMAPClient.AUTH_METHOD.PLAIN),
            Arguments.of("CRAM-MD5", AuthenticatingIMAPClient.AUTH_METHOD.CRAM_MD5),
            Arguments.of("LOGIN", AuthenticatingIMAPClient.AUTH_METHOD.LOGIN),
            Arguments.of("XOAUTH", AuthenticatingIMAPClient.AUTH_METHOD.XOAUTH),
            Arguments.of("XOAUTH2", AuthenticatingIMAPClient.AUTH_METHOD.XOAUTH2)
        );
    }

}
