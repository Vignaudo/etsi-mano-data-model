/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.dao.mano.nsd.wan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;

import com.ubiqube.etsi.mano.dao.mano.nsd.wan.type.PolicyType;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@Embeddable
public class RouteMapDistribution implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private PolicyType policy;

	private BigDecimal sequence;
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> matchAndSetRule;

}
