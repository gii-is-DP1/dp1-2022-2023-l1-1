/*
 * Copyright 2002-2013 the original author or authors.
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
package org.springframework.samples.petclinic.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public List<User> getAll(){
		return userRepository.findAll();
	}

	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		User user = userRepository.findById(username).get();
		return user;
	}

	@Transactional(readOnly = true)
	public List<User> getUsersWithAuthority(String authority) {
		return userRepository.findUserWithAuthority(authority);
	}

	@Transactional
    public void saveUser(User user) throws DataAccessException {
        user.setEnabled(true);
        userRepository.save(user);
    }

}
