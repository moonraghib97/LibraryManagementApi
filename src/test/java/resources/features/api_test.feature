Feature: API Testing with JWT Authentication

############################################ FOR BOOKS NOW ###################################

##1
#  Scenario: Test an API with valid JWT token /members
#    Given I have a valid JWT token
#    When I send a GET request to "/members"
#    Then the response status code should be 200
#    And the response should contain "expectedValue"
#2
  Scenario: Test an API with valid JWT token /api/books
    Given I have a valid JWT token
    When I send a GET request to "/api/books"
    Then the response status code should be 200
    And the response should contain "expectedValue"
#3
  Scenario Outline: Test GET book by ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/api/books/<bookId>"
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | bookId |
      | 2      |

#4
  Scenario Outline: Test GET book by non-existing ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/api/books/<nonExistingId>"
    Then the response status code should be 404
    And the response should contain "expectedValue"
    Examples:
      | nonExistingId |
      | 999      |

#5
  Scenario Outline: Test POST create a new book with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "title": "<title>",
      "author": "<author>",
      "isbn": "<isbn>"
    }
    """
    When I send a POST request to "/api/books" with payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | title  | author              | isbn   |
      | Umer  | umer@example.com   | Expected Book Title |
      | Alice | alice@example.com  | Expected Book Title |

#6
  Scenario Outline: Test PUT update a book with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "title": "<title>",
      "author": "<author>",
      "isbn": "<isbn>"
    }
    """
    When I send a PUT request to "/api/books/<bookId>" with the updated payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | bookId | title            | author           | isbn |
      | 2      | Updated Title 2   | Updated Author 2  | 1234567890124 |

#7
  Scenario Outline: Test PUT update a non-existing book with valid JWT token PUT /api/books/999
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "title": "<title>",
      "author": "<author>",
      "isbn": "<isbn>"
    }
    """
    When I send a PUT request to "/api/books/<bookId>" with the updated payload
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | bookId | title            | author           | isbn |
      | 999      | Updated Title 2   | Updated Author 2  | 1234567890124 |

#8
  Scenario Outline: Test DELETE a book with valid JWT token
    Given I have a valid JWT token
    When I send a DELETE request to "/api/books/<bookId>"
    Then the response status code should be 200
    And the response should contain "updatedBookTitle"

    Examples:
      | bookId |
      | 7      |

#9
  Scenario Outline: Test DELETE a non-existing book with valid JWT token /api/books/999
    Given I have a valid JWT token
    When I send a DELETE request to "/api/books/<InvalidbookId>"
    Then the response status code should be 404
    And the response should contain "expectedBody"

    Examples:
      | InvalidbookId |
      | 999           |



    ############################################ FOR MEMBERS NOW ###################################


##1
  Scenario: Test an API with valid JWT token /members
    Given I have a valid JWT token
    When I send a GET request to "/members"
    Then the response status code should be 200
    And the response should contain "expectedValue"

##2
  Scenario Outline: Test GET member by ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/members/<memberId>"
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | memberId |
      | 1        |

##3
  Scenario Outline: Test GET member by non-existing ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/members/<nonExistingId>"
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | nonExistingId |
      | 999           |

##4
  Scenario Outline: Test POST create a new member with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "name": "<name>",
      "email": "<email>"
    }
    """
    When I send a POST request to "/members" with payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | name  | email              | expectedValue |
      | Umer  | umer@example.com   | Expected Name |
      | Alice | alice@example.com  | Expected Name |

##5
  Scenario Outline: Test PUT update a member with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "name": "<name>",
      "email": "<email>"
    }
    """
    When I send a PUT request to "/members/<memberId>" with the updated payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | memberId | name            | email              | expectedValue |
      | 1        | Updated Name 1   | updated1@example.com | Updated Name 1 |
      | 2        | Updated Name 2   | updated2@example.com | Updated Name 2 |

##6
  Scenario Outline: Test PUT update a non-existing member with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "name": "<name>",
      "email": "<email>"
    }
    """
    When I send a PUT request to "/members/<memberId>" with the updated payload
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | memberId | name            | email              | expectedValue |
      | 999      | Updated Name 999 | updated999@example.com | Not Found   |

##7
  Scenario Outline: Test DELETE a member with valid JWT token
    Given I have a valid JWT token
    When I send a DELETE request to "/members/<memberId>"
    Then the response status code should be 204
    And the response should contain "expectedResponse"

    Examples:
      | memberId |
      | 4        |

##8
  Scenario Outline: Test DELETE a non-existing member with valid JWT token
    Given I have a valid JWT token
    When I send a DELETE request to "/members/<InvalidMemberId>"
    Then the response status code should be 404
    And the response should contain "expectedResponse"

    Examples:
      | InvalidMemberId |
      | 999             |

############################################ FOR COPY NOW ###################################

##1
  Scenario: Test an API with valid JWT token /copies
    Given I have a valid JWT token
    When I send a GET request to "/copies"
    Then the response status code should be 200
    And the response should contain "expectedValue"

##2
  Scenario Outline: Test GET copy by ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/copies/<copyId>"
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | copyId |
      | 4      |

##3
  Scenario Outline: Test GET copy by non-existing ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/copies/<nonExistingId>"
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | nonExistingId |
      | 999           |

##4
  Scenario Outline: Test POST create a new copy with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "status": "<status>",
      "bookId": <bookId>
    }
    """
    When I send a POST request to "/copies" with payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | status   | bookId | expectedValue  |
      | available | 6     | Created Copy 1 |
      | checked_out | 2  | Created Copy 2 |

##5
  Scenario Outline: Test PUT update a copy with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "status": "<status>",
      "bookId": <bookId>
    }
    """
    When I send a PUT request to "/copies/<copyId>" with the updated payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | copyId | status        | bookId | expectedValue   |
      | 10      | unavailable   | 8      | Updated Copy 1  |
      | 2      | available     | 2      | Updated Copy 2  |

##6
  Scenario Outline: Test PUT update a non-existing copy with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "status": "<status>",
      "bookId": <bookId>
    }
    """
    When I send a PUT request to "/copies/<copyId>" with the updated payload
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | copyId | status        | bookId | expectedValue |
      | 999    | unavailable   | 1      | Not Found     |

##7
  Scenario Outline: Test DELETE a copy with valid JWT token
    Given I have a valid JWT token
    When I send a DELETE request to "/copies/<copyId>"
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | copyId |
      | 10      |

##8
  Scenario Outline: Test DELETE a non-existing copy with valid JWT token
    Given I have a valid JWT token
    When I send a DELETE request to "/copies/<InvalidCopyId>"
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | InvalidCopyId |
      | 999           |

##9
  Scenario Outline: Test GET copies by bookId with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/copies/book/<bookId>"
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | bookId |
      | 5      |
      | 2      |


############################################ FOR LOAN NOW ###################################

# M.Umer Stopping here because BELOW PORION IS NOT WORKING DUE TO LOGIC B/W BOOK, COPY AND LOANS

##1
  Scenario: Test an API with valid JWT token /loan
    Given I have a valid JWT token
    When I send a GET request to "/loan"
    Then the response status code should be 200
    And the response should contain "expectedValue"

##2
  Scenario Outline: Test GET loan by ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/loan/<loanId>"
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | loanId |
      | 1      |

##3
  Scenario Outline: Test GET loan by non-existing ID with valid JWT token
    Given I have a valid JWT token
    When I send a GET request to "/loan/<nonExistingLoanId>"
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | nonExistingLoanId |
      | 999               |

##4
  Scenario Outline: Test POST create a new loan with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "loanDate": "<loanDate>",
      "returnDate": "<returnDate>",
      "copyId": <copyId>,
      "memberId": <memberId>
    }
    """
    When I send a POST request to "/loan" with payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | loanDate    | returnDate  | copyId | memberId | expectedValue |
      | 2024-03-05  | 2024-09-15  | 5      | 5        | Loan Created  |

##5
  Scenario Outline: Test PUT update a loan with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "loanDate": "<loanDate>",
      "returnDate": "<returnDate>",
      "copyId": <copyId>,
      "memberId": <memberId>
    }
    """
    When I send a PUT request to "/loan/<loanId>" with the updated payload
    Then the response status code should be 200
    And the response should contain "expectedValue"

    Examples:
      | loanId | loanDate    | returnDate  | copyId | memberId | expectedValue |
      | 1      | 2024-09-01  | 2024-09-10  | 1      | 2        | Loan Updated  |
      | 2      | 2024-09-05  | 2024-09-15  | 2      | 3        | Loan Updated  |

##6
  Scenario Outline: Test PUT update a non-existing loan with valid JWT token
    Given I have a valid JWT token
    And I have the following payload:
    """
    {
      "loanDate": "<loanDate>",
      "returnDate": "<returnDate>",
      "copyId": <copyId>,
      "memberId": <memberId>
    }
    """
    When I send a PUT request to "/loan/<loanId>" with the updated payload
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | loanId | loanDate    | returnDate  | copyId | memberId | expectedValue |
      | 999    | 2024-09-01  | 2024-09-10  | 1      | 2        | Not Found     |

##7
  Scenario Outline: Test DELETE a loan with valid JWT token
    Given I have a valid JWT token
    When I send a DELETE request to "/loan/<loanId>"
    Then the response status code should be 204
    And the response should contain "expectedValue"

    Examples:
      | loanId |
      | 2      |

##8
  Scenario Outline: Test DELETE a non-existing loan with valid JWT token
    Given I have a valid JWT token
    When I send a DELETE request to "/loan/<InvalidLoanId>"
    Then the response status code should be 404
    And the response should contain "expectedValue"

    Examples:
      | InvalidLoanId |
      | 999           |
