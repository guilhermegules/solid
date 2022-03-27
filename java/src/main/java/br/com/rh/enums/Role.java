package br.com.rh.enums;

public enum Role {
    ASSISTANT {
        @Override
        public Role getNextRole() {
            return ANALYST;
        }
    },
    ANALYST {
        @Override
        public Role getNextRole() {
            return SPECIALIST;
        }
    },
    SPECIALIST {
        @Override
        public Role getNextRole() {
            return null;
        }
    },
    MANAGER {
        @Override
        public Role getNextRole() {
            return MANAGER;
        }
    };

    public abstract Role getNextRole();
}
