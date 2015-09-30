CREATE TABLE image (
    id UUID PRIMARY KEY,
    created_date TIMESTAMP DEFAULT now(),
    created_by TEXT DEFAULT 'UNKNOWN',
    last_modified_date TIMESTAMP DEFAULT now(),
    last_modified_by TEXT DEFAULT 'UNKNOWN',
    title TEXT,
    status TEXT,
    size INTEGER DEFAULT 0,
    mimetype TEXT
);