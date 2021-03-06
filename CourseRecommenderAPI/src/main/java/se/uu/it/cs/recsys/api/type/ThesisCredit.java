package se.uu.it.cs.recsys.api.type;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/*
 * #%L
 * CourseRecommenderAPI
 * %%
 * Copyright (C) 2015 Yong Huang  <yong.e.huang@gmail.com >
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


/**
 *
 * @author Yong Huang &lt;yong.e.huang@gmail.com>&gt;
 */
@XmlType
@XmlEnum(Integer.class)
public enum ThesisCredit {

    @XmlEnumValue("30") THIRTY(30), 
    @XmlEnumValue("45") FORTY_FIVE(45);

    private final int credit;

    ThesisCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return this.credit;
    }

    public static ThesisCredit ofValue(int argCredit) {
        switch (argCredit) {
            case 30:
                return THIRTY;
            case 45:
                return FORTY_FIVE;
            default:
                throw new IllegalArgumentException(argCredit
                        + "is not a valid thesis credit");
        }
    }

}
