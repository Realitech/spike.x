/**
 *
 * Copyright (c) 2015 NG Modular Oy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package io.spikex.core.util.connection;

import com.google.common.base.Preconditions;
import java.util.List;

/**
 *
 * @param <E>
 * @author cli
 */
public abstract class AbstractLoadBalancingStrategy<E extends IConnection> implements ILoadBalancingStrategy<E> {

    private List<E> m_connections;

    @Override
    public void setConnections(final List<E> connections) {
        //
        // Sanity checks
        //
        Preconditions.checkNotNull(connections);
        Preconditions.checkArgument(connections.size() > 0, "Empty connection list");
        //
        m_connections = connections;
    }

    protected final List<E> getConnections() {
        return m_connections;
    }
}
