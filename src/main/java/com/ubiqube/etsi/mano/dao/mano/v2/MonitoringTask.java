/**
 *     Copyright (C) 2019-2023 Ubiqube.
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
package com.ubiqube.etsi.mano.dao.mano.v2;

import com.ubiqube.etsi.mano.dao.mano.MonitoringParams;
import com.ubiqube.etsi.mano.dao.mano.VnfCompute;
import com.ubiqube.etsi.mano.dao.mano.VnfIndicator;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@Entity
public class MonitoringTask extends VnfTask {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private MonitoringParams monitoringParams;

	@ManyToOne(fetch = FetchType.LAZY)
	private VnfCompute vnfCompute;

	@ManyToOne(fetch = FetchType.LAZY)
	private VnfIndicator vnfIndicator;

	@ManyToOne(fetch = FetchType.LAZY)
	private VnfInstance vnfInstance;

	private String parentAlias;

	@Override
	public VnfTask copy() {
		final MonitoringTask t = new MonitoringTask();
		super.copy(t);
		t.setMonitoringParams(monitoringParams);
		t.setVnfCompute(vnfCompute);
		t.setVnfIndicator(vnfIndicator);
		t.setParentAlias(parentAlias);
		t.setVnfInstance(vnfInstance);
		return t;
	}

}
