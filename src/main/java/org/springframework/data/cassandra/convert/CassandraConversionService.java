/*
 * Copyright 2013-2014 the original author or authors.
 *
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
 */
package org.springframework.data.cassandra.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.convert.JodaTimeConverters;

/**
 * Date: 17.12.13 17:01
 *
 * @author Alexandr V Solomatin
 */
final public class CassandraConversionService extends DefaultConversionService {

    public CassandraConversionService() {
        // register jodaTime converters
        for (final Converter jodaConverter: JodaTimeConverters.getConvertersToRegister()) {
            addConverter(jodaConverter);
        }

        // register byteBuf converters
        addConverter(new ArrayOfBytesToByteBufConverter());
        addConverter(new ByteBufToArrayOfBytesConverter());
        addConverter(new UriToStringConverter());
        addConverter(new StringToUriConverter());
    }

}
