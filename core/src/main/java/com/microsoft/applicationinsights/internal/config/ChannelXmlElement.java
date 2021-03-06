/*
 * AppInsights-Java
 * Copyright (c) Microsoft Corporation
 * All rights reserved.
 *
 * MIT License
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the ""Software""), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.applicationinsights.internal.config;

import com.google.common.base.Strings;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gupele on 3/15/2015.
 */
@XmlRootElement(name="Channel")
public class ChannelXmlElement {

    private String endpointAddress;
    private boolean developerMode;
    private String type = "com.microsoft.applicationinsights.channel.concrete.inprocess.InProcessTelemetryChannel";

    public String getType() {
        return type;
    }

    @XmlAttribute(name="type")
    public void setType(String type) {
        this.type = type;
    }

    public String getEndpointAddress() {
        return endpointAddress;
    }

    @XmlElement(name="EndpointAddress")
    public void setEndpointAddress(String endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

    public boolean getDeveloperMode() {
        return developerMode;
    }

    @XmlElement(name="DeveloperMode")
    public void setDeveloperMode(boolean developerMode) {
        this.developerMode = developerMode;
    }

    public Map<String, String> getData() {
        HashMap<String, String> data = new HashMap<String, String>();
        if (developerMode) {
            data.put("DeveloperMode", "true");
        }

        if (!Strings.isNullOrEmpty(endpointAddress)) {
            data.put("EndpointAddress", endpointAddress);
        }

        return data;
    }
}
